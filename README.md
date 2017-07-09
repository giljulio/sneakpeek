# sneakpeek [![Build Status](https://travis-ci.org/giljulio/sneakpeek.svg?branch=master)](https://travis-ci.org/giljulio/sneakpeek)

Preview your android XML custom attributes in Android Studio with the tools namespace. At run time this library falls back to the platform implementation of TypedArray.

## Usage

Retrieve the TypedArray:
```
SneakPeekTypedArray.obtainStyledAttributes(view, R.styeable.LabelTextLayout, attrs);
```
You can override `apps` namespace with a `tools` namespace just as if you were working with `android` namespace.
```
<com.example.widget.LabelTextLayout
        ...
        app:label="Username"
        tools:label="Preview username label"
        ...
        />        
```


## Install

```
compile "com.giljulio:sneakpeek:0.1.1"
```
Snapshots of the development version are available in [Sonatype's snapshots repository](https://oss.sonatype.org/content/repositories/snapshots/).

## License
```
Copyright (C) 2017 Gil Julio

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```