# WeatherUpdates

This weather app returns weather information for various cities worldwide. 

It consumes JSON weather data from an external API using RestTemplate.
Required weather data are extracted from the response result and used to create an instance of a local Weather Object which is returned 
to the client on request.

Weather oblject is cached using Redis Cache for faster retrieval.
