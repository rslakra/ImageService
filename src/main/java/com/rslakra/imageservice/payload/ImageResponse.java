/*
 * Copyright 2019 the original author or authors.
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
package com.rslakra.imageservice.payload;

import java.util.Date;

/**
 * The File Upload Response.
 */
public class ImageResponse {
	private String title;
	private Date createdOn;
	private String type;
	private long size;
	private String downloadUrl;

	/**
	 * @param title
	 * @param createdOn
	 * @param type
	 * @param size
	 * @param downloadUrl
	 */
	public ImageResponse(String title, Date createdOn, String type, long size, String downloadUrl) {
		this.title = title;
		this.createdOn = createdOn;
		this.type = type;
		this.size = size;
		this.downloadUrl = downloadUrl;
	}

	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return
	 */
	public String getDownloadUrl() {
		return downloadUrl;
	}

	/**
	 * @param downloadUrl
	 */
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size
	 */
	public void setSize(long size) {
		this.size = size;
	}
}
