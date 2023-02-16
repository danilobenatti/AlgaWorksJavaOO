package pregnancy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Calculator {
	
	private Date dataUltimoPeriodoMenstrual;
	
	public Calculator(Date dataUltimoPeriodoMenstrual) {
		this.dataUltimoPeriodoMenstrual = dataUltimoPeriodoMenstrual;
	}
	
	private Calendar converterDateParaCalendar(Date data) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(data);
		return calendar;
	}
	
	public Date calcularDataEstimadaConcepcao() {
		Calendar dataEstimadaDaConcepcao = converterDateParaCalendar(
				dataUltimoPeriodoMenstrual);
		dataEstimadaDaConcepcao.add(Calendar.WEEK_OF_YEAR, 2);
		return dataEstimadaDaConcepcao.getTime();
	}
	
	public Date calcularDataEstimadaParto() {
		Calendar dataEstimadaParto = converterDateParaCalendar(
				dataUltimoPeriodoMenstrual);
		dataEstimadaParto.add(Calendar.WEEK_OF_YEAR, 40);
		return dataEstimadaParto.getTime();
	}
	
}
