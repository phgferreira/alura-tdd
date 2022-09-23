package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
	A_DESEJAR {
		@Override
		public BigDecimal pegaReajusteSalarial() {
			return new BigDecimal("0.03");
		}
	},
	BOM {
		@Override
		public BigDecimal pegaReajusteSalarial() {
			return new BigDecimal("0.15");
		}
	},
	OTIMO {
		@Override
		public BigDecimal pegaReajusteSalarial() {
			return new BigDecimal("0.2");
		}
	},
	EXCEPCIONAL {
		@Override
		public BigDecimal pegaReajusteSalarial() {
			return new BigDecimal("0.4");
		}
	};
	
	public abstract BigDecimal pegaReajusteSalarial();
}
