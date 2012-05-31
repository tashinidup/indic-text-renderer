BASE_PATH := $(call my-dir)
LOCAL_PATH:= $(call my-dir)

#############################################################
#   build the harfbuzz library
#

include $(CLEAR_VARS)

LOCAL_ARM_MODE := arm

LOCAL_MODULE_TAGS := optional

LOCAL_CPP_EXTENSION := .cc

LOCAL_CFLAGS := -DHAVE_OT

LOCAL_SRC_FILES:= \
        src/hb-blob.cc \
        src/hb-buffer.cc \
        src/hb-common.cc \
        src/hb-fallback-shape.cc \
        src/hb-font.cc \
        src/hb-ft.cc \
        src/hb-ot-layout.cc \
        src/hb-ot-map.cc \
        src/hb-ot-shape.cc \
        src/hb-ot-shape-complex-arabic.cc \
        src/hb-ot-shape-complex-indic.cc \
        src/hb-ot-shape-complex-misc.cc \
        src/hb-ot-shape-normalize.cc \
        src/hb-ot-tag.cc \
        src/hb-set.cc \
        src/hb-shape.cc \
        src/hb-tt-font.cc \
        src/hb-unicode.cc \

LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/src $(LOCAL_PATH)/../freetype/include

LOCAL_MODULE:= libharfbuzz

LOCAL_STATIC_LIBRARIES := ft2

include $(BUILD_STATIC_LIBRARY)

