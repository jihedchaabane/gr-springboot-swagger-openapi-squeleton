# gr-springboot-swagger-openapi-squeleton
-----------------------------------------------------
http://localhost:1112/swagger-ui/index.html
http://10.0.0.137:1112/swagger-ui/index.html

curl http://10.0.0.137:1112/hello
-----------------------------------------------------
IN "10.0.0.137" do:
-----------------------------------------------------
sudo firewall-cmd --add-port=1112/tcp --permanent
sudo firewall-cmd --reload

sudo firewall-cmd --list-ports
sudo firewall-cmd --list-all

---Fermer le port 1112 -------------------------------
sudo firewall-cmd --permanent --remove-port=1112/tcp
sudo firewall-cmd --reload

sudo firewall-cmd --list-ports
sudo firewall-cmd --list-all

