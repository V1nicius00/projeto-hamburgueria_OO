package main.model;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

@Entity
public class Worker extends Pessoa {
	
		private LocalDate dataAdmissao;
		private LocalTime horarioEntrada;
		private LocalTime horarioSaida;

	//construtor vazio
		public Worker(){
			
		}
		//construtor com parâmetros
		public Worker(String nome, String sexo, Integer CPF, LocalDate dataAdmissao, LocalTime horarioEntrada, LocalTime horarioSaida) {
			super(nome, CPF, sexo);
			this.dataAdmissao = dataAdmissao;
			this.horarioEntrada = horarioEntrada;
			this.horarioSaida = horarioSaida;
		}
		//getters e setters
		public void setDataAdmissao(LocalDate dataAdmissao) {
			this.dataAdmissao = dataAdmissao;
		}
		
		public void setHorarioEntrada(LocalTime horarioEntrada) {
			this.horarioEntrada = horarioEntrada;
		}
		
		public void setHorarioSaida(LocalTime horarioSaida) {
			this.horarioSaida = horarioSaida;
		}
		
		public LocalDate getDataAdmissao() {
			return dataAdmissao;
		}
		
		public LocalTime getHorarioEntrada() {
			return horarioEntrada;
		}
		
		public LocalTime getHorarioSaida() {
			return horarioSaida;
		}

		@Override
		public String toString() {
		//visualmente como vai ser apresentado para o usuário
		return 	"ID: " + getId() + "\n" +
				"Funcionário:" + getName() + "\n" +
				"CPF:" + getCPF() + "\n" +
				"Sexo: " + getSex() + "\n" +
				"Data de Admissão: " + getDataAdmissao() + "\n" +
				"Horário de Entrada: " + getHorarioEntrada() + "\n" +
				"Horário de Saída: " + getHorarioSaida();
		}

		public String toStringOrder(){
			return 	"\nFuncionário:" + getName() + "\n" +
					"ID: " + getId() + "\n";
		}
	}	