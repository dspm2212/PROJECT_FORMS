import json
import pandas as pd
import os

RESPONSES_FILE = "data/responses.json"

def generate_report():
    """Genera un reporte de respuestas por formulario."""
    if not os.path.exists(RESPONSES_FILE):
        return {"message": "No responses available"}

    with open(RESPONSES_FILE, "r") as file:
        responses = json.load(file)

    if not responses:
        return {"message": "No responses available"}

    # Convertir respuestas a DataFrame
    df = pd.DataFrame(responses)

    # Generar reporte de cantidad de respuestas por formulario
    report = df.groupby("formId")["answers"].count().to_dict()

    return report
