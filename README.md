# camel

## Postgres
sudo -i -u postgres

postgres@ubuntu:~$ psql

postgres=# ALTER USER postgres PASSWORD 'newPassword';

postgres=# \q
postgres@ubuntu:~$ createdb -p 5432 -h localhost -e localDB
Password: 
CREATE DATABASE "localDB";
postgres@ubuntu:~$ 
