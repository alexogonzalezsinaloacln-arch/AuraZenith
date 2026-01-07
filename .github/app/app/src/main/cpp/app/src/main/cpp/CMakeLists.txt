cmake_minimum_required(VERSION 3.22.1)
project("zenith_engine")

add_library(zenith_engine SHARED aura-engine.cpp)

find_library(log-lib log)

target_link_libraries(zenith_engine ${log-lib})
