INSERT INTO unidades_medidas (nome, sigla) VALUES ('Quilograma', 'KG'),
                                              ('Litro', 'LIT'),
                                              ('Metro', 'MTR'),
                                              ('Unidade', 'UNI'),
                                              ('Grama', 'GRM'),
                                              ('Mililitro', 'MLT'),
                                              ('Centímetro', 'CM'),
                                              ('Metro Quadrado', 'M2'),
                                              ('Metro Cúbico', 'M3'),
                                              ('Peça', 'PC');

INSERT INTO tipos_produtos (nome) VALUES ('Bebidas Alcoólicas'),
                                        ('Bebidas Não Alcoólicas'),
                                        ('Sucos'),
                                        ('Refrigerantes'),
                                        ('Cervejas'),
                                        ('Vinhos'),
                                        ('Destilados'),
                                        ('Água Mineral'),
                                        ('Chás'),
                                        ('Cafés');

INSERT INTO tipos_materias_primas (nome) VALUES ('Legumes'),
                                              ('Vegetais'),
                                              ('Frutas'),
                                              ('Cereais'),
                                              ('Carnes'),
                                              ('Laticínios'),
                                              ('Frutos do Mar'),
                                              ('Especiarias'),
                                              ('Óleos Vegetais'),
                                              ('Nozes e Sementes');


INSERT INTO processos (etapa, custo) VALUES ('Fermentação', 100),
                                           ('Cozimento', 80),
                                           ('Embalagem', 50),
                                           ('Pasteurização', 120),
                                           ('Secagem', 90),
                                           ('Filtragem', 70),
                                           ('Mistura', 60),
                                           ('Esterilização', 110),
                                           ('Emulsificação', 75),
                                           ('Cristalização', 85);