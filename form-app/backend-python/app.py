from flask import Flask
from routes.response_routes import response_bp

app = Flask(__name__)

# Registrar rutas
app.register_blueprint(response_bp)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
