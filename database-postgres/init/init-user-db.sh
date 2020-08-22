##!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER xxx WITH PASSWORD 'xxx';
    CREATE DATABASE electronic_warehouse;
    GRANT ALL PRIVILEGES ON DATABASE electronic_warehouse TO xxx;
EOSQL
