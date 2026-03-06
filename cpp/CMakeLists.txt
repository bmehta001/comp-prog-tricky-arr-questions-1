cmake_minimum_required(VERSION 3.14)
project(CompProgArrayQuestions LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Each question is a standalone executable
add_executable(q1_cow_sightings question1_cow_sightings.cpp)
add_executable(q2_two_sum_bounded question2_two_sum_bounded.cpp)
add_executable(q3_largest_k_with_negative question3_largest_k_with_negative.cpp)
