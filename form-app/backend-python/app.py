"""
This module has main
------------
Entry point for the Python backend application. Initializes the Flask app,
registers the blueprints, and runs the server.

Author: Daniel Santiago Perez Madera <dsperezm@udistrital.edu.co> and Jaider Santiago Avila Robles <jsquimbaya@udistrital.edu.co>

This file is part of form apo.

form apo is free software: you can redistribute it and/or 
modify it under the terms of the GNU General Public License as 
published by the Free Software Foundation, either version 3 of 
the License or (at your option) any later version.

form apo is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
General Public License for more details.

You should have received a copy of the GNU General Public License 
along with form apo. If not, see <https://www.gnu.org/licenses/>.
"""
from flask import Flask
from routes.response_routes import response_bp

app = Flask(__name__)

# Registrar rutas
app.register_blueprint(response_bp)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
