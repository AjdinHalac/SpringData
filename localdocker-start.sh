#!/usr/bin/env bash

if [ $# -eq 0 ];
then
    ./gradlew build && docker build -t spring-data:dev-master . && docker-compose up
    exit
else

while getopts "dxq" OPTION
do
	case $OPTION in
		d)
			./gradlew build && docker build -t spring-data:dev-master . && docker-compose up -d
			exit
			;;
		x)
			docker-compose up
			exit
			;;
		q)
			docker-compose up -d
			exit
			;;
	esac
done

fi