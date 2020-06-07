/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bench;

import com.example.boot.BootApplication;
import com.example.func.FuncApplication;

import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dave Syer
 *
 */
public class LauncherStateTests {

	@Rule
	public OutputCapture output = new OutputCapture();

	@Test
	public void isolated() throws Exception {
		// System.setProperty("bench.args", "-verbose:class");
		LauncherState state = new LauncherState();
		state.isolated();
		output.flush();
		assertThat(output.toString()).contains("Benchmark app started");
		state.close();
	}

	@Test
	public void shared() throws Exception {
		// System.setProperty("bench.args", "-verbose:class");
		LauncherState state = new LauncherState();
		state.shared();
		output.flush();
		assertThat(output.toString()).contains("Benchmark app started");
		state.close();
	}

	@Test
	public void func() throws Exception {
		// System.setProperty("bench.args", "-verbose:class");
		LauncherState state = new LauncherState();
		state.setMainClass(FuncApplication.class);
		state.shared();
		output.flush();
		assertThat(output.toString()).contains("Benchmark app started");
		state.close();
	}

	@Test
	public void boot() throws Exception {
		// System.setProperty("bench.args", "-verbose:class");
		LauncherState state = new LauncherState();
		state.setMainClass(BootApplication.class);
		state.shared();
		output.flush();
		assertThat(output.toString()).contains("Benchmark app started");
		state.close();
	}

}
