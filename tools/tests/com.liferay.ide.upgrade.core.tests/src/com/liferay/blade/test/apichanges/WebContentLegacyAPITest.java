/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.blade.test.apichanges;

import com.liferay.blade.api.FileMigrator;
import com.liferay.blade.api.Problem;
import com.liferay.blade.test.Util;

import java.io.File;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Gregory Amerson
 * @author Terry Jia
 */
public class WebContentLegacyAPITest extends APITestBase {

	@Override
	public int getExpectedNumber() {
		return 5;
	}

	@Override
	public String getImplClassName() {
		return "WebContentLegacyAPI";
	}

	@Override
	public File getTestFile() {
		return new File("projects/legacy-apis-ant-portlet/docroot/WEB-INF/src/com/liferay/LegacyAPIsAntPortlet.java");
	}

	@Test
	public void webContentLegacyAPITest() throws Exception {
		FileMigrator fmigrator = context.getService(fileMigrators[0]);

		List<Problem> problems = fmigrator.analyze(getTestFile());

		context.ungetService(fileMigrators[0]);

		Assert.assertNotNull(problems);
		Assert.assertEquals("", 5, problems.size());

		Problem problem = problems.get(0);

		Assert.assertEquals(20, problem.lineNumber);

		if (Util.isWindows()) {
			Assert.assertEquals("", 961, problem.startOffset);
			Assert.assertEquals("", 1023, problem.endOffset);
		}
		else {
			Assert.assertEquals("", 942, problem.startOffset);
			Assert.assertEquals("", 1004, problem.endOffset);
		}

		problem = problems.get(1);

		Assert.assertEquals(47, problem.lineNumber);

		if (Util.isWindows()) {
			Assert.assertEquals("", 1917, problem.startOffset);
			Assert.assertEquals("", 1950, problem.endOffset);
		}
		else {
			Assert.assertEquals("", 1871, problem.startOffset);
			Assert.assertEquals("", 1904, problem.endOffset);
		}

		problem = problems.get(2);

		Assert.assertEquals(21, problem.lineNumber);

		if (Util.isWindows()) {
			Assert.assertEquals("", 1033, problem.startOffset);
			Assert.assertEquals("", 1099, problem.endOffset);
		}
		else {
			Assert.assertEquals("", 1013, problem.startOffset);
			Assert.assertEquals("", 1079, problem.endOffset);
		}

		problem = problems.get(3);

		Assert.assertEquals("", 41, problem.lineNumber);

		if (Util.isWindows()) {
			Assert.assertEquals("", 1637, problem.startOffset);
			Assert.assertEquals("", 1695, problem.endOffset);
		}
		else {
			Assert.assertEquals("", 1597, problem.startOffset);
			Assert.assertEquals("", 1655, problem.endOffset);
		}

		problem = problems.get(4);

		Assert.assertEquals(45, problem.lineNumber);

		if (Util.isWindows()) {
			Assert.assertEquals("", 1830, problem.startOffset);
			Assert.assertEquals("", 1873, problem.endOffset);
		}
		else {
			Assert.assertEquals("", 1786, problem.startOffset);
			Assert.assertEquals("", 1829, problem.endOffset);
		}
	}

}