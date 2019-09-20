Step #1: Start zookeeper-server:
--------------------------------------------------------------------------------
bin/zookeeper-server-start.sh  config/zookeeper.properties



Step #2: Start kafka-server:
--------------------------------------------------------------------------------
bin/kafka-server-start.sh config/server.properties 



Step #3: Create a topic (using the topic management tool):
--------------------------------------------------------------------------------
bin/kafka-topics.sh --zookeeper localhost:2181 --create --topic myfirsttopic --partitions 2 --replication-factor 1


Step #4: Create a producer
--------------------------------------------------------------------------------
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic myfirsttopic



Step #5: Create a consumer
--------------------------------------------------------------------------------
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic myfirsttopic



