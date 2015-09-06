/*
 * Copyright 2015 Jan Kühle
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dropbox.client2.jsonextract;

import static org.json.simple.JSONValue.toJSONString;

import java.util.List;
import java.util.Map;

public final class JsonExtractionException extends Exception {

    private static final long serialVersionUID = -5744582005002105505L;

    public JsonExtractionException(String path, String message, Object value) {
        super((path == null ? "" : path + ": ") + message +
              (value == null ? "" : ": " + summarizeValue(value)));
    }

    private static String summarizeValue(Object value) {
        if (value instanceof Map) {
            StringBuilder buf = new StringBuilder();
            @SuppressWarnings("unchecked")
            Map<String,Object> map = (Map<String,Object>) value;
            buf.append("{");
            String sep = "";
            for (Map.Entry<String,Object> entry : map.entrySet()) {
                buf.append(sep); sep = ", ";
                buf.append(toJSONString(entry.getKey()));
                buf.append(" = ");
                buf.append("...");
            }
            buf.append("}");
            return buf.toString();
        }
        else if (value instanceof List) {
            List<?> list = (List<?>) value;
            if (list.isEmpty()) {
                return "[]";
            } else if (list.size() == 1) {
                return "[" + summarizeValue(list.get(0)) + "]";
            } else {
                return "[" + summarizeValue(list.get(0)) + ", ...] (" + list.size() + " elements)";
            }
        }
        else {
            return toJSONString(value);
        }
    }
}
