package dao;

import model.Cuenta;

public interface CuentasDao {
	Cuenta findById(int idcuenta);
	void updateSaldo(int idcuenta, double nuevoSaldo);
}
