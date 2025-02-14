"""
This module report_service
------------------------
Provides functionality to generate reports based on the stored responses.

Author: Daniel Santiago Perez Madera <dsperezm@udistrital.edu.co> and Jaider Santiago Avila Robles <jsquimbaya@udistrital.edu.co>

This file is part of form app.

form app is free software: you can redistribute it and/or 
modify it under the terms of the GNU General Public License as 
published by the Free Software Foundation, either version 3 of 
the License or (at your option) any later version.

form app is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
General Public License for more details.

You should have received a copy of the GNU General Public License 
along with form app. If not, see <https://www.gnu.org/licenses/>.
"""

import json
import os
import pandas as pd

RESPONSES_FILE = "data/responses.json"

def generate_report():
    """
    Generate a report of responses grouped by form ID.

    This function reads the responses from the RESPONSES_FILE, converts the data into a
    Pandas DataFrame, and groups the responses by the 'formId' field, counting the number
    of answers per form.

    Returns:
        dict: A dictionary representing the count of responses per form.
              If no responses are available, returns a dictionary with a message.
    """
    if not os.path.exists(RESPONSES_FILE):
        return {"message": "No responses available"}

    with open(RESPONSES_FILE, "r") as file:
        responses = json.load(file)

    if not responses:
        return {"message": "No responses available"}

   
    df = pd.DataFrame(responses)

    report = df.groupby("formId")["answers"].count().to_dict()

    return report
