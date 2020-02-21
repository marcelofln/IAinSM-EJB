package com.facade;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.TimerDAO;
import com.model.Fluxo;
import com.model.TimerIA;

@Stateless
public class TimerFacadeImpl implements TimerFacade {

	@EJB
	private TimerDAO timerDAO;

	// Crio o EJB do Facade para ter acesso ao Save.
	@EJB
	private FluxoFacade fluxoFacade;

	static boolean ligado;
	private Timer timer;
	private Fluxo fluxo;
	String[] nomeAcoes = { "ALL AMER LAT", "AMBEV", "BRASIL", "BRADESCO",
			"BROOKFIELD", "BRADESPAR", "BRF FOODS", "BRASKEM", "BR MALLS PAR",
			"BMFBOVESPA", "CCR SA", "CIELO", "CEMIG", "SOUZA CRUZ", "COSAN",
			"SID NACIONAL", "CETIP", "CYRELA REALT", "DASA", "ELETROPAULO",
			"FIBRIA", "GAFISA", "GERDAU", "GERDAU MET", "GOL", "CIA HERING",
			"HYPERMARCAS", "ITAUSA", "ITAUUNIBANCO", "JBS", "LOJAS AMERIC",
			"LOJAS RENNER", "MMX MINER", "MARFRIG", "MRV", "NATURA",
			"OGX PETROLEO", "OI", "PDG REALT", "PETROBRAS", "PETROBRAS",
			"LOCALIZA", "ROSSI RESID", "SANTANDER BR", "SUZANO PAPEL",
			"TIM PART S/A", "USIMINAS", "VALE", "VALE", "TELEF BRASIL", };

	String[] codNegociacao = { "ALLL3", "AMBV4", "BBAS3", "BBDC4", "BISA3",
			"BRAP4", "BRFS3", "BRKM5", "BRML3", "BVMF3", "CCRO3", "CIEL3",
			"CMIG4", "CRUZ3", "CSAN3", "CSNA3", "CTIP3", "CYRE3", "DASA3",
			"ELPL4", "FIBR3", "GFSA3", "GGBR4", "GOAU4", "GOLL4", "HGTX3",
			"HYPE3", "ITSA4", "ITUB4", "JBSS3", "LAME4", "LREN3", "MMXM3",
			"MRFG3", "MRVE3", "NATU3", "OGXP3", "OIBR4", "PDGR3", "PETR3",
			"PETR4", "RENT3", "RSID3", "SANB11", "SUZB5", "TIMP3", "USIM5",
			"VALE3", "VALE5", "VIVT4", };

	private TimerThread t2;

	public TimerThread getT2() {
		if (t2 == null) {
			t2 = new TimerThread();
			t2.start();
		}

		if (t2.getState().toString() == "TERMINATED") {
			t2 = new TimerThread();
			t2.start();
		}

		return t2;
	}

	public void setT2(TimerThread t2) {
		this.t2 = t2;
	}

	// instancia o TimerIA para evitar NullPointerException
	public Fluxo getFluxo() {
		if (fluxo == null) {
			fluxo = new Fluxo();
		}
		return fluxo;
	}

	public void setFluxo(Fluxo fluxo) {
		this.fluxo = fluxo;
	}

	@Override
	public void save(TimerIA timerIA) {
		isTimerWithAllData(timerIA);

		try {
			timerDAO.save(timerIA);
			ligar(timerIA);
		} catch (Exception e) {

		}
	}

	@Override
	public void delete(TimerIA timerIA) {
		timerDAO.delete(timerIA);

	}

	@Override
	public TimerIA update(TimerIA timerIA) {
		isTimerWithAllData(timerIA);
		ligar(timerIA);
		return timerDAO.update(timerIA);
	}

	@Override
	public TimerIA findTimerByEmail(String email) {
		return timerDAO.findTimerByEmail(email);
	}

	@Override
	public TimerIA find(int entityID) {
		return timerDAO.find(entityID);
	}

	@Override
	public List<TimerIA> findAll() {
		return timerDAO.findAll();
	}

	private void ligar(TimerIA timerIA) {

		Calendar calendarioInicio = new GregorianCalendar(getTimeZone());
		Calendar calendarioFim = new GregorianCalendar(getTimeZone());

		calendarioInicio.setTime(timerIA.getDateInicial());
		calendarioFim.setTime(timerIA.getDateFinal());

		Date timeInicio = calendarioInicio.getTime();
		Date timeFim = calendarioFim.getTime();

		timer = new Timer();
		timer.schedule(new InicioColeta(), timeInicio);
		timer.schedule(new FimColeta(), timeFim);

	}

	public class InicioColeta extends TimerTask {

		/**
		 * O schedule do timer inicia a coleta
		 * 
		 */

		@Override
		public void run() {

			ligado = true;

			getT2();

			System.out.println("Iniciei Timer  " + timer + ligado
					+ " Thread acoes esta " + t2.getState());

			if (t2.getState().equals("RUNNABLE")) {

				t2.notify();
				System.out.println("Acordei o Timer  " + timer + ligado
						+ " Thread acoes esta " + t2.getState());
			}

			if (t2.getState().toString() == "TERMINATED") {

				getT2();
				System.out.println("Entei no Timer novamente " + timer + ligado
						+ " Thread acoes esta " + t2.getState());
			}

		}
	}

	public class FimColeta extends TimerTask {

		/**
		 * O schedule do timer finaliza a coleta
		 */

		@Override
		public void run() {

			ligado = false;

			if (ligado == false) {
				t2.interrupt();
				System.out.println("Entrei no desligar " + timer + ligado
						+ " Thread acoes esta " + t2.getState());

			}
		}
	}

	public class TimerThread extends Thread {

		@Override
		public void run() {

			while (!isInterrupted()) {

				Random r1 = new Random();
				Random r2 = new Random();
				Random r3 = new Random();
				Random r4 = new Random();
				Random r5 = new Random();
				Random r6 = new Random();
				Random r7 = new Random();
				Random r9 = new Random();

				try {

					Thread.sleep(2000);
					Calendar calendarioThread = new GregorianCalendar(
							getTimeZone());
					calendarioThread = Calendar.getInstance();

					Date data_pregao = calendarioThread.getTime();

					int numero = r6.nextInt(50);

					String cod_negociacao = codNegociacao[numero].trim()
							.toString();
					String nome_empresa = nomeAcoes[numero].trim().toString();
					float p_abertura = r5.nextFloat() * 10;
					float p_maximo = r3.nextFloat() * 10;
					float p_minimo = r4.nextFloat() * 10;
					float p_medio = r1.nextFloat() * 10;
					float p_m_oferta_compra = r7.nextFloat() * 10;
					float p_m_oferta_venda = r9.nextFloat() * 10;
					float vol_total = r2.nextFloat() * 10;

					getFluxo().setData_pregao(data_pregao);
					getFluxo().setCod_negociacao(cod_negociacao);
					getFluxo().setNome_empresa(nome_empresa);
					getFluxo().setPreco_abertura(p_abertura);
					getFluxo().setPreco_maximo(p_maximo);
					getFluxo().setPreco_minimo(p_minimo);
					getFluxo().setPreco_medio(p_medio);
					getFluxo().setPreco_melhor_oferta_compra(p_m_oferta_compra);
					getFluxo().setPreco_melhor_oferta_venda(p_m_oferta_venda);
					getFluxo().setVolume_total(vol_total);

					fluxoFacade.update(fluxo);

					System.out.println("  Data: " + data_pregao + " Papel: "
							+ cod_negociacao + " Nome Empresa: " + nome_empresa
							+ " preco abertura " + p_abertura
							+ " preco maximo " + p_maximo + " preco minimo "
							+ p_minimo + " Preco Medio " + p_medio
							+ " Preco melhor oferta compra "
							+ p_m_oferta_compra + " Preco melhor oferta venda "
							+ p_m_oferta_venda + " Volume Total " + vol_total

					);
					
					matchStop(fluxo);

				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

	
	public void matchStop(Fluxo fluxo){
		System.out.println("Consigo " + fluxo.getCod_negociacao());
	}
	
	
	private void isTimerWithAllData(TimerIA timerIA) {
		boolean hasError = false;

		if (timerIA == null) {
			hasError = true;
		}

		if (timerIA.getEmailIA() == null
				|| "".equals(timerIA.getEmailIA().trim())) {
			hasError = true;
		}

		if (hasError) {
			throw new IllegalArgumentException(
					"Houveram inconsitemcia de dados gravação abortada.");
		}

	}

	// Metodo que devolve a timeZone correta
	public TimeZone getTimeZone() {
		return TimeZone.getDefault();
	}

	@Override
	public List<TimerIA> findListTimerByEmail(String emailIA) {
		return timerDAO.findListTimerByEmail(emailIA);
	}

}
