INSERT INTO labo.tabela (codigo, nome, esquema) VALUES (1, 'tbbairro', 'sfcl');
INSERT INTO labo.tabela (codigo, nome, esquema) VALUES (2, 'tblogradouro', 'sfcl');
INSERT INTO labo.tabela (codigo, nome, esquema) VALUES (3, 'tbrpa', 'sfcl');


INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(1, 1, 'cbairrcodi', 'numeric', 4, NULL, 'NO', 'Codigo do bairro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(1, 2, 'ebairrnome', 'character varying', NULL, 55, 'YES', 'Nome do bairro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(1, 3, 'cmicrocodi', 'numeric', 1, NULL, 'YES', 'Codigo da microrregiao');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(1, 4, 'crpaaacodi', 'numeric', 2, NULL, 'YES', 'Codigo da RPA');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(1, 5, 'tbairrulat', 'timestamp without time zone', NULL, NULL, 'NO', NULL);

INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 1, 'clogracodi', 'numeric', 6, NULL, 'NO', 'Codigo do logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 2, 'nlogranome', 'character varying', NULL, 55, 'YES', 'Nome do logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 3, 'clogracant', 'numeric', 6, NULL, 'YES', 'Codigo anterior do logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 4, 'clogranato', 'numeric', 5, NULL, 'YES', 'Numero do ato da origem do logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 5, 'clograanoa', 'numeric', 4, NULL, 'YES', 'Ano do numero do ato da origem do logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 6, 'vlograexte', 'numeric', 7, NULL, 'YES', 'Extensao do logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 7, 'coriglcodi', 'numeric', 2, NULL, 'YES', 'Codigo da origem do logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 8, 'ctitulcodi', 'character', NULL, 10, 'YES', 'Codigo do titulo do logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 9, 'ctplogcodi', 'character', NULL, 3, 'YES', 'Codigo do tipo de logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 10, 'cprepocodi', 'character', NULL, 3, 'YES', 'Codigo da preposicao do nome do logradouro');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 11, 'flograsitu', 'character', NULL, 1, 'YES', 'Indica se o logradouro esta extinto ou nao');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 12, 'tlograulat', 'timestamp without time zone', NULL, NULL, 'NO', 'Data e hora da ultima atualizacao');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 13, 'cemprecodi', 'numeric', 2, NULL, 'YES', 'Codigo da empresa');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(2, 14, 'ausuacmatr', 'numeric', 11, NULL, 'YES', 'Matricula do usuario');

INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(3, 1, 'crpaaacodi', 'numeric', 2, NULL, 'NO', 'Codigo da RPA');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(3, 2, 'erpaaadesc', 'character varying', NULL, 55, 'YES', 'Descricao da RPA');
INSERT INTO labo.coluna (codigo_tabela, codigo, nome, tipo, precisao, tamanho, eh_nulo, descricao) VALUES(3, 3, 'trpaaaulat', 'timestamp without time zone', NULL, NULL, 'NO', 'Data e hora da ultima atualizacao');