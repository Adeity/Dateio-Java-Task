## Dateio Java Task - implementation
### What I have done
I created a Java Spring Boot application using multi-tier architecture.
### Endpoints
```
paths:
  /offer/{offerId}:
    post:
      summary: Get offer by offerId
      responses:
          '200':
          description: Offer object
          content:
            application/json:
              schema:
                type: object
                properties:
                  id:
                    type: integer
                    example: 4
                  name:
                    type: string
                    example: Awesome offer
                  visibleFrom:
                    type: string
                    example: 2015-05-15 00:00:00+00
                  visibleTo:
                    type: string
                    example: 2015-05-15 00:00:00+00
                  description:
                    type: string
                    example: Offer description
          '404':
            description: Offer with offerId not found
  /userBehaviour:
    post:
      summary: Post a UserBehaviourDTO
      requestBody:
        required: true
        content:
          application/json:
            schema:      # Request body contents
              type: object
              properties:
                clientId:
                  type: integer
                offerId:
                  type: string
                isOfferActive:
                  type: boolean
                isOfferSeen:
                  type: boolean
                lastSeen:
                  type: string
                  example: 2022-02-02T10:23:46.000+0200
              example:   # Sample object
                "clientId": 1,
                "offerId": 1,
                "isOfferActive": true,
                "isOfferSeen": true,
                "lastSeen": "2022-02-02T10:23:46.000+0200"
      responses:
          '200':
          description: User behaviour saved
          '400':
          description: Attributes were null or wrong format
          '404':
          description: Client with clientId not found or Offer with offerId not found
```
### How to start using Docker
- Pull the source code
- Build from the root of this project using command: docker build -t dateio-task:1.0 .
- Run using: docker-compose -f docker-compose.yaml up -d