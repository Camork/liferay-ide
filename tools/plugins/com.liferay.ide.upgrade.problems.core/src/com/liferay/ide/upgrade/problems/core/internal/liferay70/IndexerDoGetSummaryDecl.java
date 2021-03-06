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

package com.liferay.ide.upgrade.problems.core.internal.liferay70;

import java.io.File;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.ide.upgrade.problems.core.FileMigrator;
import com.liferay.ide.upgrade.problems.core.FileSearchResult;
import com.liferay.ide.upgrade.problems.core.JavaFile;
import com.liferay.ide.upgrade.problems.core.internal.JavaFileMigrator;

/**
 * @author Gregory Amerson
 */
@Component(property = {
	"file.extensions=java",
	"problem.summary=Changed the AssetRenderer and Indexer APIs to Include the PortletRequest and PortletResponse " +
		"Parameters",
	"problem.tickets=LPS-44639,LPS-44894", "problem.title=Indexer API Changes",
	"problem.section=#changed-the-assetrenderer-and-indexer-apis-to-include-the-portletrequest-an",
	"implName=IndexerDoGetSummaryDecl", "version=7.0"
},
	service = FileMigrator.class)
public class IndexerDoGetSummaryDecl extends JavaFileMigrator {

	@Override
	protected List<FileSearchResult> searchFile(File file, JavaFile javaFileChecker) {
		return javaFileChecker.findMethodDeclaration(
			"doGetSummary", new String[] {"Document", "Locale", "String", "PortletURL"}, null);
	}

}