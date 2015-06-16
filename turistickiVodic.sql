drop database if exists turistickiVodic;
create database turistickiVodic DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci;
use turistickiVodic;

CREATE TABLE kategorija(
	sifra int not null primary key auto_increment,
	nazivKategorije text not null) engine=innodb; 


CREATE TABLE tockaInteresa(

	sifra int not null primary key auto_increment,
	naziv varchar(50) not null,
	adresa varchar (100) not null,
	kratakOpis text not null,
	detaljanOpis text,
	putanja text not null)engine=innodb;
	
CREATE TABLE rejting (
	sifra int not null primary key auto_increment,
	tockaInteresa int not null,
	datum DATE not null,
	komentar varchar(250),
	ocjena int not null) engine=innodb;	
	
	
CREATE TABLE vezaKategorija (
	tockaInteresa int not null,
	kategorija int not null) engine=innodb;

create table operater(
	sifra		int not null primary key auto_increment,
	korisnickoime varchar(10) not null,
	lozinka	char(32) not null,
	ime		varchar(50) not null,
	prezime		varchar(50) not null
)engine=innodb;
	


alter table vezaKategorija add foreign key (tockaInteresa) references tockaInteresa(sifra);
alter table vezaKategorija add foreign key (kategorija) references kategorija(sifra);
alter table rejting add foreign key (tockaInteresa) references tockaInteresa(sifra);

#1
INSERT into kategorija(nazivKategorije) values ('rooms');
#2
INSERT into kategorija(nazivKategorije) values ('food');
#3
INSERT into kategorija(nazivKategorije) values ('exchange office');
#4
INSERT into kategorija(nazivKategorije) values ('wifi');
#5
INSERT into kategorija(nazivKategorije) values ('grocery store');
#6
INSERT into kategorija(nazivKategorije) values ('pharmacy');
#7
INSERT into kategorija(nazivKategorije) values ('post office');
#8
INSERT into kategorija(nazivKategorije) values ('police station');
#9
INSERT into kategorija(nazivKategorije) values ('attractions');
#10
INSERT into kategorija(nazivKategorije) values ('school');
#11
INSERT into kategorija(nazivKategorije) values ('café');


#1
INSERT into tockaInteresa(naziv, adresa, kratakOpis, putanja) values ('t.o. Savić', 'Bana Josipa Jelačića 21', 
'In this kiosk You can exchange your money into Croatian kunas, buy phone SIM cards, newspapers and other usefull stuff.',
'https://maps.googleapis.com/maps/api/staticmap?center=45.4869653,18.9814319&zoom=16&size=800x800&markers=color:blue|label:m|45.4867605,18.9829386');


#2
INSERT into tockaInteresa(naziv, adresa, kratakOpis, putanja) values ('Stari mlin', 'Ulica Braće Radić 23', 
'Na obali Dunava, različite generacije obitelji Đurkov su udahnuli novi život preuredivši prostor nekdašnjeg starog mlina. 
Stoljetna građevina je danas reprezentativni ugostiteljski prostor, u kojemu možete pronaći salu za svadbe kao i druge velike svečanosti koja može primiti oko 500 gostiju, 
restoran koji je pogodan za manje proslave i može ugostiti 200-injak gostiju. 
Terasa s pogledam na Dunav, zidani roštilji, dvorište s velikim ograđenim parkingom, uslužno osobolje, ugodna i opuštajuća seoska atmosfera može 
Vam garantirati nezaboravan odmor i uživanje u domaćoj gastronomiji kao i različitoj ponudi lokalnih vinara.',
'https://maps.googleapis.com/maps/api/staticmap?center=45.489411,18.992486&zoom=15&size=800x800&markers=color:blue|label:m|45.489411,18.992486');


#3
INSERT into tockaInteresa(naziv, adresa, kratakOpis, putanja) values ('NTL supermarket', 'Bana Josipa Jelačića 19', 
'NTL is regional supermarket. http://www.ntl.com.hr/',
'https://maps.googleapis.com/maps/api/staticmap?center=45.4869653,18.9814319&zoom=16&size=800x800&markers=color:blue|label:m|45.4867605,18.9829386');




#4
INSERT into tockaInteresa(naziv, adresa, kratakOpis, putanja) values ('Caffe bar Boss', 'Alojzija Stepinca 19', 
'In Caffe bar Boss You can use WiFi and enjoy good coffee.', 
'https://maps.googleapis.com/maps/api/staticmap?center=45.48702,18.98592&zoom=16&size=800x800&markers=color:blue|label:m|45.48702,18.98592');

#5
INSERT into tockaInteresa(naziv, adresa, kratakOpis, putanja) values ('Pharmacy', 'Slavka Kolara 2', 
'Opening hours:
Monday: od 7:00 am - 3:00 pm
Tuesday: od 12:00 am do 8:00 pm
Wednesday: od 7:00 am do 3:00 pm
Thursday: od 12:00 am do 8:00 pm
Friday: od 7:00 am do 3:00 pm',
'https://maps.googleapis.com/maps/api/staticmap?center=45.486057,18.982379&zoom=16&size=800x800&markers=color:blue|label:m|45.486057,18.982379');
 
#6
INSERT into tockaInteresa(naziv, adresa, kratakOpis, putanja) values ('Police Station', 'Ulica Josipa Glibušića 1', 
'Phone:031 590 123',
'https://maps.googleapis.com/maps/api/staticmap?center=45.4845067,18.9834522&zoom=16&size=800x800&markers=color:blue|label:m|45.483574,18.985083');

#7
INSERT into tockaInteresa(naziv, adresa, kratakOpis, putanja) values ('Post Office', 'Bana Josipa Jelačića 18', 
'Opening hours:
Monday to Friday - 8:00 am - 2:00 pm',
'https://maps.googleapis.com/maps/api/staticmap?center=45.4864221,18.9838814&zoom=16&size=800x800&markers=color:blue|label:m|45.4864221,18.9838814');

#8
INSERT into tockaInteresa(naziv, adresa, kratakOpis, putanja) values ('Teutoburgium', 'Zagrebačka 1', 
'Teutoburgium is wine museum...',
'https://maps.googleapis.com/maps/api/staticmap?center=45.484688,18.986263&zoom=16&size=800x800&markers=color:blue|label:m|45.484688,18.986263');



INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(1, 3);
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(1, 5);
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(2, 1);
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(2, 2);		
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(2, 4);	
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(3, 5);		
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(4, 4);				
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(4, 11);	
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(5, 6);				
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(6, 8);		
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(7, 7);			
INSERT INTO vezaKategorija(tockaInteresa,kategorija) values
			(8, 9);					
			
insert into operater(korisnickoime,lozinka,ime,prezime) values ('mklajic',md5('m'),'Maja','Klajić');
insert into operater(korisnickoime,lozinka,ime,prezime) values ('tjakopec',md5('t'),'Tomislav','Jakopec');
insert into operater(korisnickoime,lozinka,ime,prezime) values ('zbosnjak',md5('z'),'Zoran','Bošnjak');
insert into operater(korisnickoime,lozinka,ime,prezime) values ('mstrok',md5('ms'),'Mario','Štrok');
insert into operater(korisnickoime,lozinka,ime,prezime) values ('mvalentic',md5('mv'),'Mario','Valentić');
insert into operater(korisnickoime,lozinka,ime,prezime) values ('imatkovic',md5('i'),'Ivan','Matković');
insert into operater(korisnickoime,lozinka,ime,prezime) values ('fmaric',md5('f'),'Filip','Marić');

insert into rejting(tockaInteresa,datum,komentar,ocjena) values (1,'2014-07-21','friendly staff!',5);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (1,'2014-08-26','good deals!',5);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (2,'2014-06-21','friendly staff..',4);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (2,'2014-07-13','delicious food!',5);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (2,'2014-05-27','incompetent waiter!',2);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (3,'2014-02-21','we were waiting in line at the cash register for a long time!',2);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (3,'2014-08-26','good deals!',5);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (4,'2014-09-21','friendly staff...',4);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (4,'2014-07-07','we were waiting for a waiter 15 minutes!!!',2);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (5,'2014-06-03','very helpful pharmacist!',5);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (5,'2014-10-11','pharmacy is closed during the weekend!',3);
insert into rejting(tockaInteresa,datum,komentar,ocjena) values (8,'2014-06-21','nice iterior...',5);
	insert into rejting(tockaInteresa,datum,komentar,ocjena) values (8,'2014-08-14','great wine collection!',3);