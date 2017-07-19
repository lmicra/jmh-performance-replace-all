package net.individual.jmhreplaceall;

import java.io.*;
import static java.util.concurrent.TimeUnit.*;
import java.util.function.Function;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.*;
import org.openjdk.jmh.runner.options.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(MICROSECONDS)
@Warmup(iterations = 5, time = 400, timeUnit = MILLISECONDS)
@Measurement(iterations = 4, time = 1000, timeUnit = MILLISECONDS)
// @Warmup(iterations = 2)
// @Measurement(iterations = 3)
@Fork(2)
public class TranslationUtilsAbstractBenchmark {

	private final PrintStream sout = System.out;

	@Setup
	public void setup() {
		System.setOut(new PrintStream(new OutputStream() {
			@Override
			public void write(int b) {
				//DO NOTHING
			}
		}));
	}

	@TearDown
	public void tearDown() {
		System.setOut(this.sout);
	}

	protected void testAMethod(Function<String, String> fn) {
		for (String s1 : SampleText.TEXT) {
			String s2 = fn.apply(s1);
			if (!s1.equals(s2)) {
				System.out.println(s1 + " > " + s2);
			}
		}
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(".*" + TranslationUtilsAbstractBenchmark.class.getSimpleName() + ".*")
				// .verbosity(VerboseMode.NORMAL)
				// .addProfiler(org.openjdk.jmh.profile.GCProfiler.class)
				// .resultFormat(ResultFormatType.SCSV)
				// .output("/tmp/benchmarks.txt")
				.build();

		new Runner(opt).run();
	}
}
