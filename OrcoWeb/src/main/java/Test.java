import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class Test extends ApplicationFrame{
	public Test(String title) {
		super(title);
		setTitle(title);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1088327407010441627L;

	private static PieDataset createDataset( )
	{
		DefaultPieDataset dataset = new DefaultPieDataset( );
		dataset.setValue( "IPhone 5s" , new Double( 20 ) );
		dataset.setValue( "SamSung Grand" , new Double( 20 ) );
		dataset.setValue( "MotoG" , new Double( 40 ) );
		dataset.setValue( "Nokia Lumia" , new Double( 10 ) );
		return dataset;
	}

	private static JFreeChart createChart( PieDataset dataset )
	{
		JFreeChart chart = ChartFactory.createPieChart(
				"Mobile Sales", // chart title
				dataset, // data
				true, // include legend
				true,
				false
				);
		return chart;
	}

	public static JFreeChart createDemoPanel( )
	{
		return createChart(createDataset( ) );
	}

	public static void main(String[] args) {
		ChartPanel panel = new ChartPanel(createChart(createDataset()));
		Test demo = new Test("cito");
		demo.setContentPane(panel);
		demo.setSize( 560 , 367 );
		RefineryUtilities.centerFrameOnScreen( demo );
		demo.setVisible( true );
	}
}
