#!/usr/bin/env zsh

. scripts/cleanandbuild.zsh.inc

cleanandbuild "java" "server/build/libs" "server.jar"