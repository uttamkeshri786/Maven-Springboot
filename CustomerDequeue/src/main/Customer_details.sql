------------ Create table of CUSTOMERDetails ----------------
   CREATE TABLE "CUSTOMER_DETAILS" 
   (	"CUSTNO" NUMBER(4,0), 
	"ENAME" VARCHAR2(20 BYTE), 
	"JOB" VARCHAR2(20 BYTE), 
	"SAL" NUMBER(7,2), 
	"DEPTNO" NUMBER(2,0), 
	"HIREDATE" DATE );


   ALTER TABLE CUSTOMER_DETAILS
    ADD PRIMARY KEY (CNO);


-------------------CREATE SEQUENCE ------------------------

CREATE SEQUENCE CUSTOMER_DETAILS_SEQUENCE
	INCREMENT BY 1 
	MAXVALUE 999999 
	MINVALUE 1 
	CACHE 20 ;

---------------------CREATE INDEX----------------------------

 CREATE INDEX CUST_NO ON CUSTOMER_DETAILS (CUSTNO);
 CREATE INDEX CUSTOMER_SAL ON CUSTOMER_DETAILS (SAL);


-----------------ALTER CUSTOMER_DETAILS--------------------------------

   ALTER TABLE CUSTOMER_DETAILS ADD (VALIDATION_COUNT NUMBER);

----------------------CREATE TYPE-------------------------

CREATE OR REPLACE TYPE CUST_NOTIFY AS OBJECT
    ( notification_id NUMBER(19,0)
    ) ;
/


-------------------CREATE QUEUE TABLE----------------

EXECUTE DBMS_AQADM.CREATE_QUEUE_TABLE (	queue_table => 'CUSTOMER_DETAILS_QT',	queue_payload_type => 'ACCOUNT');
EXECUTE DBMS_AQADM.CREATE_QUEUE (queue_name => 'CUSTOMER_DETAILS_Q',queue_table => 'CUSTOMER_DETAILS_QT');
EXECUTE DBMS_AQADM.START_QUEUE (queue_name => 'CUSTOMER_DETAILS_Q');

======================================================================================================


----------------------CREATE PROCEDURE----------------------------

create or replace PROCEDURE CUSTOMER_DETAILS_ENQUEUE(CUSTNO IN NUMBER, INPUT_DELAY IN NUMBER default 0)
AS
   enqueue_options DBMS_AQ.enqueue_options_t;
   message_properties DBMS_AQ.message_properties_t;
   message_handle RAW(16);
   message CUST_NOTIFY;
BEGIN
    message := CUST_NOTIFY(CUSTNO);
    message_properties.delay := INPUT_DELAY;
     DBMS_AQ.ENQUEUE(
         queue_name => 'CUSTOMER_DETAILS_Q',
         enqueue_options => enqueue_options,
         message_properties => message_properties,
         payload => message,
         msgid => message_handle);
END;
/
SHOW ERROR;

-------------------CREATE TRIGGER------------------------------------------------

create or replace trigger CUSTOMER_DETAILS_INSERT_TRG
BEFORE insert on CUSTOMER_DETAILS
for each row
DECLARE
   message_handle RAW(16);
begin
  CUSTOMER_DETAILS_ENQUEUE(:new.CUSTNO);
end;
/
SHOW ERROR;




