package TPOFinal;

public class nReinas {
	int cantReinas=8;
	int [] tablero=new int[cantReinas];
	static int count=0;
	
	public static void main(String[] args) {
		nReinas e=new nReinas();
		int media=0;
		int n=10;
		long inicio;
		long fin;
		//for (int i = 0; i < 10; i++) {
		inicio=System.nanoTime();
		e.check(0);
		fin= System.nanoTime();
		//System.out.println("EXITO AL EJECUTAR. TIEMPO DE EJECUCION: "+ (fin-inicio)+"ns");
		media+=fin-inicio;
		//}
		System.out.printf("Hay% d soluciones en total",count);
		//System.out.println();
		//System.out.println("MEDIA RECURSIVO: "+ media/n+"ns \n");
	}
	
	private void check(int etapa) {//t14= t(n-1)*n + 16n^2 + 8n +3 <--RECURRENCIA siendo c una constante definida por el tamaño del tablero
		if(etapa!=tablero.length) {//t15= 1comp+1op+t16=1+(t(n-1)+16n+8)*n + 2= t(n-1)*n + 16n^2 + 8n +3
			for (int i = 0; i < tablero.length; i++) {//t16= 1asig(1comp+1op+1asig+t17+t18)*n=1+(1+1+1+2+t(n-1)+16n+2)*n= 1+(t(n-1)+16n+8)*n 
				tablero[etapa]=i;//t17= 1acc+1comp=2
				if(judge(etapa)) {//t18=t27+t19=t(n-1)+16n+2
					check(etapa+1);//t19=t(n-1)
				}
			}
		}else {
			print();//t23=t37=7n+3
		}
	}
	
	private boolean judge(int etapa) {
		boolean exito=true;
		for (int i = 0; i < etapa; i++) {
			if(tablero[i]==tablero[etapa]|| Math.abs(etapa-i)==Math.abs(tablero[etapa]-tablero[i])) {
				exito=false;
			}
		}
		return exito;
	}
	
	private void print() {//t37=t38+t39+t42= 1+7n+1+1=7n+3
		count++;//t38=1op=1
		for (int i = 0; i < tablero.length; i++) {//t39=1asig+(1comp+1op+1asig+3)*n=7n+1
			System.out.print(tablero[i]+" ");//t40=1acc+1op+1salida=3
		}
		System.out.println();//t42=1salida=1
	}
}
