# camel

## Postgres
sudo -i -u postgres

postgres@ubuntu:~$ psql

postgres=# ALTER USER postgres PASSWORD 'newPassword';

postgres=# \q

createdb -p 5432 -h localhost -e localDB

## list databases
\l 

## switch DB
\c localDB
