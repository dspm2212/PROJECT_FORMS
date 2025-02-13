from flask import Blueprint, request, jsonify
from services.response_service import save_response
from services.report_service import generate_report

response_bp = Blueprint("response_bp", __name__)

@response_bp.route("/process_responses", methods=["POST"])
def process_responses():
    data = request.json  # Recibe datos desde Java
    if not data:
        return jsonify({"error": "No data received"}), 400

    # Guardar respuesta en JSON
    save_response(data)

    # Generar reporte actualizado
    report = generate_report()

    return jsonify({"message": "Responses processed", "report": report})
