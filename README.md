# Survey

## QRcode for Testing : https://android-lab-group-1.github.io/ in https://li.riino.site/download/question.json

## Questionnaire WebSite : http://xiaonan.ngrok2.xiaomiqiu.cn/server/


dingbot test.
## Team member

Part abc:
  
- riino(Shih-Chi Chang)

- PXNPXN(Xiao-Nan Peng)

- blessiy(Jian Li)

Part bd: 

- FromFire(Jing-Wen Cheng)

- Moshu(Shu Mo)

## Status

a.Web Server: done.(front end by Riino; back end and POST/GET procedure by PXN)

b.Main menu: 90% DONE (By PXN)

 - Dynamic listview: TODO


c.QR Scanner: DONE (By PXN and Moshu) 
*(Abandon version by Riino in early version)


d.Save answer： DONE (By fromfire))

e.Lock and save answers : 90% DONE (By Moshu )

 - Sync between local and server : TODO

## DB Structure

- TABLE Survey

col integer INT (increasing)

col surveyID TEXT

col surveyJsonString TEXT


- TABLE answer

col id INT

col latitude DOUBLE 

col timestamp DOUBLE 

col IMEI char(20)

col answer TEXT


##File Tree
├─android-client
│  ├─.gradle
│  │  ├─5.6.4
│  │  │  ├─executionHistory
│  │  │  ├─fileChanges     
│  │  │  ├─fileContent     
│  │  │  ├─fileHashes      
│  │  │  ├─javaCompile     
│  │  │  └─vcsMetadata-1
│  │  ├─buildOutputCleanup
│  │  └─vcs-1
│  ├─.idea
│  │  ├─caches
│  │  ├─codeStyles
│  │  └─libraries
│  ├─app
│  │  ├─build
│  │  │  ├─generated
│  │  │  │  ├─ap_generated_sources
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─res
│  │  │  │  │  ├─pngs
│  │  │  │  │  │  └─debug
│  │  │  │  │  │      ├─drawable-anydpi-v21
│  │  │  │  │  │      ├─drawable-hdpi
│  │  │  │  │  │      ├─drawable-ldpi
│  │  │  │  │  │      ├─drawable-mdpi
│  │  │  │  │  │      ├─drawable-xhdpi
│  │  │  │  │  │      ├─drawable-xxhdpi
│  │  │  │  │  │      └─drawable-xxxhdpi
│  │  │  │  │  └─resValues
│  │  │  │  │      └─debug
│  │  │  │  └─source
│  │  │  │      └─buildConfig
│  │  │  │          └─debug
│  │  │  │              └─com
│  │  │  │                  └─example
│  │  │  │                      └─survey
│  │  │  ├─intermediates
│  │  │  │  ├─annotation_processor_list
│  │  │  │  │  └─debug
│  │  │  │  ├─apk_list
│  │  │  │  │  └─debug
│  │  │  │  ├─blame
│  │  │  │  │  └─res
│  │  │  │  │      └─debug
│  │  │  │  │          ├─multi-v2
│  │  │  │  │          └─single
│  │  │  │  ├─bundle_manifest
│  │  │  │  │  └─debug
│  │  │  │  │      └─bundle-manifest
│  │  │  │  ├─compatible_screen_manifest
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─compile_and_runtime_not_namespaced_r_class_jar
│  │  │  │  │  └─debug
│  │  │  │  ├─data_binding_layout_info_type_merge
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─dex
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─dex_archive_input_jar_hashes
│  │  │  │  │  └─debug
│  │  │  │  ├─duplicate_classes_check
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─external_libs_dex
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─external_libs_dex_archive
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─incremental
│  │  │  │  │  ├─debug-mergeJavaRes
│  │  │  │  │  │  └─zip-cache
│  │  │  │  │  ├─debug-mergeNativeLibs
│  │  │  │  │  │  └─zip-cache
│  │  │  │  │  ├─mergeDebugAssets
│  │  │  │  │  ├─mergeDebugJniLibFolders
│  │  │  │  │  ├─mergeDebugResources
│  │  │  │  │  │  ├─merged.dir
│  │  │  │  │  │  │  ├─values
│  │  │  │  │  │  │  ├─values-af
│  │  │  │  │  │  │  ├─values-am
│  │  │  │  │  │  │  ├─values-ar
│  │  │  │  │  │  │  ├─values-as
│  │  │  │  │  │  │  ├─values-az
│  │  │  │  │  │  │  ├─values-b+sr+Latn
│  │  │  │  │  │  │  ├─values-be
│  │  │  │  │  │  │  ├─values-bg
│  │  │  │  │  │  │  ├─values-bn
│  │  │  │  │  │  │  ├─values-bs
│  │  │  │  │  │  │  ├─values-ca
│  │  │  │  │  │  │  ├─values-cs
│  │  │  │  │  │  │  ├─values-da
│  │  │  │  │  │  │  ├─values-de
│  │  │  │  │  │  │  ├─values-el
│  │  │  │  │  │  │  ├─values-en-rAU
│  │  │  │  │  │  │  ├─values-en-rCA
│  │  │  │  │  │  │  ├─values-en-rGB
│  │  │  │  │  │  │  ├─values-en-rIN
│  │  │  │  │  │  │  ├─values-en-rXC
│  │  │  │  │  │  │  ├─values-es
│  │  │  │  │  │  │  ├─values-es-rUS
│  │  │  │  │  │  │  ├─values-et
│  │  │  │  │  │  │  ├─values-eu
│  │  │  │  │  │  │  ├─values-fa
│  │  │  │  │  │  │  ├─values-fi
│  │  │  │  │  │  │  ├─values-fr
│  │  │  │  │  │  │  ├─values-fr-rCA
│  │  │  │  │  │  │  ├─values-gl
│  │  │  │  │  │  │  ├─values-gu
│  │  │  │  │  │  │  ├─values-h720dp-v13
│  │  │  │  │  │  │  ├─values-hdpi-v4
│  │  │  │  │  │  │  ├─values-hi
│  │  │  │  │  │  │  ├─values-hr
│  │  │  │  │  │  │  ├─values-hu
│  │  │  │  │  │  │  ├─values-hy
│  │  │  │  │  │  │  ├─values-in
│  │  │  │  │  │  │  ├─values-is
│  │  │  │  │  │  │  ├─values-it
│  │  │  │  │  │  │  ├─values-iw
│  │  │  │  │  │  │  ├─values-ja
│  │  │  │  │  │  │  ├─values-ka
│  │  │  │  │  │  │  ├─values-kk
│  │  │  │  │  │  │  ├─values-km
│  │  │  │  │  │  │  ├─values-kn
│  │  │  │  │  │  │  ├─values-ko
│  │  │  │  │  │  │  ├─values-ky
│  │  │  │  │  │  │  ├─values-land
│  │  │  │  │  │  │  ├─values-large-v4
│  │  │  │  │  │  │  ├─values-ldltr-v21
│  │  │  │  │  │  │  ├─values-lo
│  │  │  │  │  │  │  ├─values-lt
│  │  │  │  │  │  │  ├─values-lv
│  │  │  │  │  │  │  ├─values-mk
│  │  │  │  │  │  │  ├─values-ml
│  │  │  │  │  │  │  ├─values-mn
│  │  │  │  │  │  │  ├─values-mr
│  │  │  │  │  │  │  ├─values-ms
│  │  │  │  │  │  │  ├─values-my
│  │  │  │  │  │  │  ├─values-nb
│  │  │  │  │  │  │  ├─values-ne
│  │  │  │  │  │  │  ├─values-night-v8
│  │  │  │  │  │  │  ├─values-nl
│  │  │  │  │  │  │  ├─values-or
│  │  │  │  │  │  │  ├─values-pa
│  │  │  │  │  │  │  ├─values-pl
│  │  │  │  │  │  │  ├─values-port
│  │  │  │  │  │  │  ├─values-pt
│  │  │  │  │  │  │  ├─values-pt-rBR
│  │  │  │  │  │  │  ├─values-pt-rPT
│  │  │  │  │  │  │  ├─values-ro
│  │  │  │  │  │  │  ├─values-ru
│  │  │  │  │  │  │  ├─values-si
│  │  │  │  │  │  │  ├─values-sk
│  │  │  │  │  │  │  ├─values-sl
│  │  │  │  │  │  │  ├─values-sq
│  │  │  │  │  │  │  ├─values-sr
│  │  │  │  │  │  │  ├─values-sv
│  │  │  │  │  │  │  ├─values-sw
│  │  │  │  │  │  │  ├─values-sw600dp-v13
│  │  │  │  │  │  │  ├─values-ta
│  │  │  │  │  │  │  ├─values-te
│  │  │  │  │  │  │  ├─values-th
│  │  │  │  │  │  │  ├─values-tl
│  │  │  │  │  │  │  ├─values-tr
│  │  │  │  │  │  │  ├─values-uk
│  │  │  │  │  │  │  ├─values-ur
│  │  │  │  │  │  │  ├─values-uz
│  │  │  │  │  │  │  ├─values-v16
│  │  │  │  │  │  │  ├─values-v17
│  │  │  │  │  │  │  ├─values-v18
│  │  │  │  │  │  │  ├─values-v21
│  │  │  │  │  │  │  ├─values-v22
│  │  │  │  │  │  │  ├─values-v23
│  │  │  │  │  │  │  ├─values-v24
│  │  │  │  │  │  │  ├─values-v25
│  │  │  │  │  │  │  ├─values-v26
│  │  │  │  │  │  │  ├─values-v28
│  │  │  │  │  │  │  ├─values-vi
│  │  │  │  │  │  │  ├─values-watch-v20
│  │  │  │  │  │  │  ├─values-watch-v21
│  │  │  │  │  │  │  ├─values-xlarge-v4
│  │  │  │  │  │  │  ├─values-zh
│  │  │  │  │  │  │  ├─values-zh-rCN
│  │  │  │  │  │  │  ├─values-zh-rHK
│  │  │  │  │  │  │  ├─values-zh-rTW
│  │  │  │  │  │  │  └─values-zu
│  │  │  │  │  │  └─stripped.dir
│  │  │  │  │  ├─mergeDebugShaders
│  │  │  │  │  ├─packageDebug
│  │  │  │  │  │  └─tmp
│  │  │  │  │  │      └─debug
│  │  │  │  │  │          └─zip-cache
│  │  │  │  │  └─processDebugResources
│  │  │  │  ├─instant_app_manifest
│  │  │  │  │  └─debug
│  │  │  │  ├─javac
│  │  │  │  │  └─debug
│  │  │  │  │      └─classes
│  │  │  │  │          └─com
│  │  │  │  │              └─example
│  │  │  │  │                  └─survey
│  │  │  │  ├─manifest_merge_blame_file
│  │  │  │  │  └─debug
│  │  │  │  ├─merged_assets
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─merged_java_res
│  │  │  │  │  └─debug
│  │  │  │  ├─merged_jni_libs
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─merged_manifests
│  │  │  │  │  └─debug
│  │  │  │  ├─merged_native_libs
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─merged_shaders
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─metadata_feature_manifest
│  │  │  │  │  └─debug
│  │  │  │  │      └─metadata-feature
│  │  │  │  ├─mixed_scope_dex_archive
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─navigation_json
│  │  │  │  │  └─debug
│  │  │  │  ├─processed_res
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─project_dex_archive
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  │          └─com
│  │  │  │  │              └─example
│  │  │  │  │                  └─survey
│  │  │  │  ├─res
│  │  │  │  │  └─merged
│  │  │  │  │      └─debug
│  │  │  │  ├─runtime_symbol_list
│  │  │  │  │  └─debug
│  │  │  │  ├─shader_assets
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─stripped_native_libs
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─sub_project_dex_archive
│  │  │  │  │  └─debug
│  │  │  │  │      └─out
│  │  │  │  ├─symbol_list_with_package_name
│  │  │  │  │  └─debug
│  │  │  │  └─validate_signing_config
│  │  │  │      └─debug
│  │  │  │          └─out
│  │  │  ├─outputs
│  │  │  │  ├─apk
│  │  │  │  │  └─debug
│  │  │  │  └─logs
│  │  │  └─tmp
│  │  │      └─compileDebugJavaWithJavac
│  │  └─src
│  │      ├─androidTest
│  │      │  └─java
│  │      │      └─com
│  │      │          └─example
│  │      │              └─survey
│  │      ├─main
│  │      │  ├─assets
│  │      │  ├─java
│  │      │  │  └─com
│  │      │  │      └─example
│  │      │  │          └─survey
│  │      │  └─res
│  │      │      ├─drawable
│  │      │      ├─drawable-v24
│  │      │      ├─layout
│  │      │      ├─mipmap-anydpi-v26
│  │      │      ├─mipmap-hdpi
│  │      │      ├─mipmap-mdpi
│  │      │      ├─mipmap-xhdpi
│  │      │      ├─mipmap-xxhdpi
│  │      │      ├─mipmap-xxxhdpi
│  │      │      └─values
│  │      └─test
│  │          └─java
│  │              └─com
│  │                  └─example
│  │                      └─survey
│  └─gradle
│      └─wrapper
└─server
    ├─.idea
    ├─css
    └─jsondata