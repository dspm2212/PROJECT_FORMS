import json
import os

RESPONSES_FILE = "data/responses.json"

def load_responses():
    """Carga las respuestas almacenadas."""
    if os.path.exists(RESPONSES_FILE):
        with open(RESPONSES_FILE, "r") as file:
            return json.load(file)
    return []

def save_response(response_data):
    """Guarda una nueva respuesta en responses.json."""
    responses = load_responses()
    responses.append(response_data)

    with open(RESPONSES_FILE, "w") as file:
        json.dump(responses, file, indent=4)
