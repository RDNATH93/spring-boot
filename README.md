# spring-booot-elastic

- run docker compose file for elasticserach,kibana,apm server
- for enrollment token run below commad  
docker exec -it elasticsearch /usr/share/elasticsearch/bin/elasticsearch-create-enrollment-token -s kibana
- for verification token run below command
 docker exec -it kibana /usr/share/kibana/bin/kibana-verification-code

- to generate service token
docker exec -it elasticsearch /bin/bash elasticsearch-service-tokens create elastic/kibana default