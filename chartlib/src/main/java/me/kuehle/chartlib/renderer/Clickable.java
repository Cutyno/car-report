/*
 * Copyright 2012 Jan Kühle
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

package me.kuehle.chartlib.renderer;

import android.graphics.PointF;

/**
 * Renderers, that provide click support, implement this interface.
 */
public interface Clickable {
	/**
	 * Performs a click at the specified point on the chart.
	 * 
	 * @param point
	 */
	public abstract void click(PointF point);

	/**
	 * Registers a listener that will be executed, if a click is performed.
	 * 
	 * @param listener
	 */
	public abstract void setOnClickListener(OnClickListener listener);
}
