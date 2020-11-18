CREATE TABLE Accionista (
	ID integer PRIMARY KEY,
	Cuit text,
	RazonSocial text NULL
);
CREATE TABLE SocioAccionista (
	ID integer PRIMARY KEY,
	IdSocio integer NULL,
	IdAccionista integer NULL,
	PorcentajeDeParticipacion integer NULL	
);
CREATE TABLE Aporte (
	ID integer PRIMARY KEY,
	Valor real NULL,
	FechaAporte integer NULL,
	IdSocio integer NULL
);
CREATE TABLE CertificadoDeGarantia (
	ID integer PRIMARY KEY,
	Numero integer NULL,
	Descripcion text NULL,
	IdOperacion integer NULL
);
CREATE TABLE Cheque (
	ID integer PRIMARY KEY,
	NroChque integer NULL,
	fechaDeVencimiento integer NULL, 
	cuitFirmante text NULL 
);
CREATE TABLE CuentaCorriente (
	ID integer PRIMARY KEY,
	EmpresaCuentaCorriente text NULL,
	ImprteTotal integer NULL, 
	FechaVencimiento integer NULL 
);
CREATE TABLE Documentacion (
	ID integer PRIMARY KEY,
	TipoDocumento text NULL,
	EstadoDoc text NULL,
	FechaRecepcion integer NULL,
	IdSocio integer NULL,
	Usuario text NULL,
	IsObligatorio integer NULL 
);
CREATE TABLE LineaDeCredito (
	ID integer PRIMARY KEY,
	Monto integer NULL,
	Vencimiento integer NULL,
	LineaAprobada integer NULL,
	TipoDeOperacion text NULL,
	IdSocio integer NULL
);
CREATE TABLE Prestamo (
	ID integer PRIMARY KEY,
	Banco text NULL,
	Importe real NULL,
	FechaDeAcreditacion integer NULL,
	CantidadCuotas integer NULL,
	Tasa integer NULL,
	Sistema text NULL
);
CREATE TABLE Socio (
	ID integer PRIMARY KEY,
	Cuit text NULL,
	RazonSocial text NULL,
	FechaInicio integer NULL,
	ActividadPrincipal text NULL,
	Direccion text NULL,
	Telefono text NULL,
	Email text NULL,
	EstadoSocio text NULL,
	TipoEmpresa text NULL,
	SaldoAcciones integer NULL,
	TipoSocio text NULL
);
CREATE TABLE Tipo1 (
	ID integer PRIMARY KEY,
	NroCheques integer NULL,
	FechaVencimiento integer NULL,
	CuitFirmante text NULL,
	IdOperacion integer NULL
);
CREATE TABLE Tipo2 (
	ID integer PRIMARY KEY,
	EmpresaCuentaCorriente text NULL,
	FechaVencimiento integer NULL,
	IdOperacion integer NULL
);
CREATE TABLE Tipo3 (
	ID integer PRIMARY KEY,
	Banco text NULL,
	FechaActualizacion integer NULL,
	CantidadDeCuotas integer NULL,
	tasa integer NULL,
	Sistema text NULL,
	IdOperacion integer NULL
);

CREATE TABLE Cuota (
	ID integer PRIMARY KEY,
	NumeroDeCuota integer NULL,
	Valor real NULL,
	Vencimiento integer NULL,
	IdTipo3 integer NULL,
	Paga integer NULL
)

CREATE TABLE Operacion (
	ID integer PRIMARY KEY,
	EstadoOperacion text NULL,
	TasaDeDescuento real NULL,
	ComisionAlSocio real NULL,
	EstadoComision text NULL,
	TipoDeOperacion text NULL,
	Monto real NULL,
	Fecha integer NULL,
	IdCerificadoDeGarantia integer NULL,
	IdSocio integer NULL
);

CREATE TABLE AporteFondoDeRiesgo (
	Monto real NULL,
	IdSocio integer NULL,
	FechaAporte integer NULL,
	AporteVigente integer NULL
)

--INSERTS

INSERT INTO Accionista (ID,RazonSocial,PorcentajeDeParticipacion) VALUES (1,'Holi',32)

INSERT INTO Aporte (ID,Valor,FechaAporte) VALUES (1,22.4,null)

INSERT INTO CertificadoDeGarantia(ID,numero,Descripcion)VALUES(1,1,'Garantia')

INSERT INTO Cheque(ID,NroChque,fechaDeVencimiento,cuitFirmante)VALUES(<ID, int,>,<NroChque, int,>,<fechaDeVencimiento, int,>,<cuitFirmante, text,>)

INSERT INTO CuentaCorriente(ID,EmpresaCuentaCorriente,ImprteTotal,FechaVencimiento)VALUES(<ID, int,>,<EmpresaCuentaCorriente, text,>,<ImprteTotal, int,>,<FechaVencimiento, int,>)

INSERT INTO Documentacion(ID,TipoDocumento,EstadoDoc,IsObligatorio) VALUES(<ID, int,>,<TipoDocumento, text,>,<EstadoDoc, text,>,<IsObligatorio, int,>)