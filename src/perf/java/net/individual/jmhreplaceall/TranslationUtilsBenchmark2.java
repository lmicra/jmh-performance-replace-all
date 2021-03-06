package net.individual.jmhreplaceall;

// import static java.util.concurrent.TimeUnit.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.*;
import org.openjdk.jmh.runner.options.*;

@State(Scope.Benchmark)
// @BenchmarkMode(Mode.AverageTime)
// @OutputTimeUnit(MICROSECONDS)
// @Warmup(iterations = 10, time = 250, timeUnit = MILLISECONDS)
// @Measurement(iterations = 25, time = 250, timeUnit = MILLISECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(2)
public class TranslationUtilsBenchmark2 extends TranslationUtilsAbstractBenchmark {

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
