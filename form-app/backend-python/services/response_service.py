"""
This module response_service
--------------------------
Provides functions to load and save responses from/to a JSON file.

Author: Daniel Santiago Perez Madera <dsperezm@udistrital.edu.co> and Jaider Santiago Avila Robles <jsquimbaya@udistrital.edu.co>

This file is part of form apo.

form app is free software: you can redistribute it and/or 
modify it under the terms of the GNU General Public License as 
published by the Free Software Foundation, either version 3 of 
the License or (at your option) any later version.

form app is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
General Public License for more details.

You should have received a copy of the GNU General Public License 
along with form apo. If not, see <https://www.gnu.org/licenses/>.
"""
import json
import os

RESPONSES_FILE = "data/responses.json"

def load_responses():
    """
    Load stored responses from the JSON file.

    Returns:
        list: A list of response objects loaded from the JSON file.
              If the file does not exist, returns an empty list.
    """
    if os.path.exists(RESPONSES_FILE):
        with open(RESPONSES_FILE, "r") as file:
            return json.load(file)
    return []

def save_response(response_data):
   """
    Save a new response to the JSON file.

    This function loads existing responses from the RESPONSES_FILE, appends the new
    response data, and writes the updated list back to the file.

    Args:
        response_data (dict): A dictionary containing the response data to be saved.
    """
   responses = load_responses()
   responses.append(response_data)

   with open(RESPONSES_FILE, "w") as file:
    json.dump(responses, file, indent=4)