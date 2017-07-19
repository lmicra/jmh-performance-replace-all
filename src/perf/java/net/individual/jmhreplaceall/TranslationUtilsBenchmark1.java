package net.individual.jmhreplaceall;

// import static java.util.concurrent.TimeUnit.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.*;
import org.openjdk.jmh.runner.options.*;

public class TranslationUtilsBenchmark1 extends TranslationUtilsAbstractBenchmark {

	@Benchmark
	public void testV01Method() {
		testAMethod(net.individual.jmhreplaceall.v01.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV02Method() {
		testAMethod(net.individual.jmhreplaceall.v02.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV03Method() {
		testAMethod(net.individual.jmhreplaceall.v03.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV04Method() {
		testAMethod(net.individual.jmhreplaceall.v04.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV05Method() {
		testAMethod(net.individual.jmhreplaceall.v05.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV06Method() {
		testAMethod(net.individual.jmhreplaceall.v06.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV07Method() {
		testAMethod(net.individual.jmhreplaceall.v07.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV08Method() {
		testAMethod(net.individual.jmhreplaceall.v08.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV09Method() {
		testAMethod(net.individual.jmhreplaceall.v09.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV10Method() {
		testAMethod(net.individual.jmhreplaceall.v10.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV11Method() {
		testAMethod(net.individual.jmhreplaceall.v11.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV12Method() {
		testAMethod(net.individual.jmhreplaceall.v12.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV13Method() {
		testAMethod(net.individual.jmhreplaceall.v13.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV14Method() {
		testAMethod(net.individual.jmhreplaceall.v14.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV15Method() {
		testAMethod(net.individual.jmhreplaceall.v15.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV16Method() {
		testAMethod(net.individual.jmhreplaceall.v16.TranslationUtils.translateFn);
	}

	@Benchmark
	public void testV17Method() {
		testAMethod(net.individual.jmhreplaceall.v17.TranslationUtils.translateFn);
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(".*" + TranslationUtilsBenchmark2.class.getSimpleName() + ".*")
				// .verbosity(VerboseMode.NORMAL)
				// .addProfiler(org.openjdk.jmh.profile.GCProfiler.class)
				// .resultFormat(ResultFormatType.SCSV)
				// .output("/tmp/benchmarks.txt")
				.build();

		new Runner(opt).run();
	}
}
