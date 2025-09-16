from flask import Flask, request
from flask_restful import Resource, Api
from flasgger import Swagger

app = Flask(__name__)
api = Api(app)
swagger = Swagger(app)

playlists = [
    {
        "playlist_id": 1,
        "playlist_name": "datenight",
        "movie_list": ["The Notebook", "50 First Dates", "A Walk to Remember"]
    },
    {
        "playlist_id": 2,
        "playlist_name": "action",
        "movie_list": ["Die Hard", "Mad Max: Fury Road", "John Wick"]
    },
    {
        "playlist_id": 3,
        "playlist_name": "comedy",
        "movie_list": ["Superbad", "Step Brothers", "The Hangover"]
    }
]

class Playlists(Resource):
    def get(self):
        """
        Get all playlists
        ---
        responses:
          200:
            description: A list of all playlists
        """
        return playlists, 200

    def post(self):
        """
        Add a new playlist
        ---
        parameters:
          - in: body
            name: Playlist
            required: true
            schema:
              id: Playlist
              required:
                - playlist_name
                - movie_list
              properties:
                playlist_name:
                  type: string
                  description: The name of the playlist
                movie_list:
                  type: array
                  items:
                    type: string
                  description: List of movies in the playlist
        responses:
          201:
            description: A new playlist created
          400:
            description: Bad request
        """
        data = request.get_json()

        if "playlist_name" not in data or "movie_list" not in data:
            return {"message": "playlist_name and movie_list are required"}, 400

        new_id = playlists[-1]['playlist_id'] + 1 if playlists else 1
        new_playlist = {
            "playlist_id": new_id,
            "playlist_name": data["playlist_name"],
            "movie_list": data["movie_list"]
        }

        playlists.append(new_playlist)
        return new_playlist, 201


# Routes
api.add_resource(Playlists, '/playlists')

# Run the app
if __name__ == '__main__':
    app.run(debug=True)

