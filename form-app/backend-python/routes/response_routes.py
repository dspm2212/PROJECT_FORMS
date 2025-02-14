"""
This module has response_routes Defines the API endpoints related to processing responses.

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
from flask import Blueprint, request, jsonify
from services.response_service import save_response
from services.report_service import generate_report

response_bp = Blueprint("response_bp", __name__)

@response_bp.route("/process_responses", methods=["POST"])
def process_responses():
    """
    Process incoming responses from the client.

    This endpoint receives JSON data representing responses (sent from the Java backend),
    saves the response to a JSON file, and generates an updated report.

    Returns:
        A JSON response with a message and the generated report if the data is valid.
        Otherwise, returns an error message with a 400 status code.
    """
    data = request.json  
    if not data:
        return jsonify({"error": "No data received"}), 400

   
    save_response(data)

    
    report = generate_report()

    return jsonify({"message": "Responses processed", "report": report})
