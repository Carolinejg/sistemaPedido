INSERT INTO cliente(documento,nome,tipo)VALUES('06421140564','caroline',1);
INSERT INTO cliente(documento,nome,tipo)VALUES('06421140564','Carlos',0);
INSERT INTO cliente(documento,nome,tipo)VALUES('06421140564','Anita',1);
INSERT INTO cliente(documento,nome,tipo)VALUES('06421140564','Paula',0);

INSERT INTO produto(descricao,unidade_Medida,valor_Unitario,status)VALUES('TV','PESO','2000',0);
INSERT INTO produto(descricao,unidade_Medida,valor_Unitario,status)VALUES('COMPUTADOR','PESO','2000',1);
INSERT INTO produto(descricao,unidade_Medida,valor_Unitario,status)VALUES('CELULAR','PESO','2000',0);
INSERT INTO produto(descricao,unidade_Medida,valor_Unitario,status)VALUES('CAMERA','PESO','2000',1);

INSERT INTO pedido(bairro,cep,cidade,data,rua,id_cliente)VALUES('federacao','40230109','salvador','2021-01-01T10:00:00Z','mata',1);
INSERT INTO pedido(bairro,cep,cidade,data,rua,id_cliente)VALUES('alto das pombas','40230109','salvador','2021-01-01T10:00:00Z','mata',2);
INSERT INTO pedido(bairro,cep,cidade,data,rua,id_cliente)VALUES('pituba','40230109','salvador','2021-01-01T10:00:00Z','mata',3);
INSERT INTO pedido(bairro,cep,cidade,data,rua,id_cliente)VALUES('ondina','40230109','salvador','2021-01-01T10:00:00Z','mata',4);