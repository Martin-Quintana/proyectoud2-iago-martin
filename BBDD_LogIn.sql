drop database if exists BBDD_LogIn;
create database if not exists BBDD_LogIn;
use BBDD_LogIn;


/* Tabla Usuarios */
drop table if exists Usuarios;
create table if not exists Usuarios
	(
		DNI char(9) not null,
		NombreCompleto varchar (50) not null,
        Usr varchar (50) not null, 
        Passwd varchar (50) not null,
        
        unique index AK_Usr_Usuario (Usr),
        
		primary key (DNI)
        
	)engine InnoDB;

/** Insertar Usuarios **/
insert into Usuarios
  (DNI, NombreCompleto, Usr, Passwd) 
values 
('77077715T', 'Fernanda la Tuerta', 'Fertuer', 'gb435qfwfe7'),
('80420759V', 'Marcos Vázquez', 'Marvaz', 'gfdg4fe7'),
('47981232N', 'Leopoldo Bastida', 'Leobas', 'dsga4556jgh'),
('79990897W', 'Avelina Ocaña', 'Aveoca', 'dsfg6jkf'),
('37900014Q', 'Sandra Melian', 'Sanmel', 'lkn45kj5'),
('25629359E', 'Nicole Barrios', 'Nicbar', 'fdhln56j5'),
('28805319G', 'Basilio Arce', 'Basarc', 'dfglkb45jh'),
('86848625G', 'Matias Clemente', 'Matcle', 'dsfsf8hrt'),
('42705711R', 'Baldomero Puerto', 'Balpue', 'esgvdfloh56i'),
    
('111111111', 'admin', 'admin', 'admin');
 
  
