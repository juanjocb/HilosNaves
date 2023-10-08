
public class HiloPersonaje extends Thread {
	private Personaje p;
	private boolean activo;
	private long espera;
	private CanvasJuego miCanvas;
	private boolean rot = true;

	private int DELTA_X = 1;
	private int DELTA_Y = 90;
	private int auxX = 0;
	private int auxY = 1;

	public HiloPersonaje(CanvasJuego c, Personaje p, long espera) {
		this.p = p;
		activo = true;
		this.espera = espera;
		miCanvas = c;

		start();
	}

	@Override
	public void run() {
		while (activo) {
			if (p.getMov() == 1) {
				if (p.getX() > miCanvas.getWidth()) {
					p.setX(0);
					p.setY(p.getY() + DELTA_Y);

					if (p.getY() > miCanvas.getHeight()) {
						p.setY(0);
					}

				} else {
					p.setX(p.getX() + DELTA_X);
				}

				try {
					sleep(espera);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else if (p.getMov() == 2) {
				if (p.getY() > miCanvas.getHeight()) {
					p.setY(0);
					p.setX(p.getX() + DELTA_Y);

					if (p.getX() > miCanvas.getWidth()) {
						p.setX(0);
					}

				} else {
					p.setY(p.getY() + DELTA_X);
				}

				try {
					sleep(espera);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else if (p.getMov() == 3) {

				if (p.getY() > miCanvas.getHeight() || p.getX() > miCanvas.getWidth()) {
					p.setY(0);
					auxX = auxX + 90;
					p.setX(auxX);

				} else {
					p.setY(p.getY() + DELTA_X);
					p.setX(p.getX() + DELTA_X);
				}

				try {
					sleep(espera);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else if (p.getMov() == 4) {

				if (p.getX() > miCanvas.getWidth() || p.getX() < 0) {
					DELTA_X = -DELTA_X;
				}

				if (p.getY() > miCanvas.getHeight() || p.getY() < 0) {
					auxY = -auxY;
				}

				p.setX(p.getX() + DELTA_X);
				p.setY(p.getY() + auxY);

				try {
					sleep(espera);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public void detener() {
		activo = false;
	}
}