# SWIM Demonstrator



This project provides a set of components for demonstrating **System Wide Information Management(SWIM),** using **Changi Airport (CAG)** airpsace with simulated track data from drones and EUROCONTROL CAT62 feeds.  
It consists of three sub-modules:

1. **cag** – A web interface for situational awareness display, focused on Changi Airport area.
2. **DronePublisherRabbit** – A program to read drone tracks from a file, convert them to JSON, and publish to RabbitMQ.
3. **trackPublisher** – A program to read EUROCONTROL CAT62 tracks from a file, convert them to JSON, and publish to a Solace broker.



Please refer to the README in each submodule for more details.

## 

## Project Structure

.
├── cag/ # Web interface for situational awareness

├── DronePublisherRabbit/ # Drone track publisher to RabbitMQ

├── trackPublisher/ # EUROCONTROL CAT62 track publisher to Solace

└── README.md

## 

## License

This project is licensed under the Apache License, Version 2.0.



## Resources

If you want to learn more about Solace Technology try these resources:

* The Solace Developer Portal website at: http://dev.solace.com
* Get a better understanding of [Solace technology](http://dev.solace.com/tech/).
* Check out the [Solace blog](http://dev.solace.com/blog/) for other interesting discussions around Solace technology
* Ask the [Solace community.](http://dev.solace.com/community/)
