.SUFFIXES: .erl .beam .yrl 

MODS := $(wildcard *.erl)

%.beam: %.erl
	erlc -W $<

ERL = erl -boot start_clean

build: beams


test: beams 
	${ERL} -pa / -s run test

test_backup: beams
	${ERL} -pa / -s run test_from_backup

test_summarize: beams
	${ERL} -pa / -s run test_summarize

oop2-2012: beams 
	${ERL} -pa / -s run oop22012

oop1: beams
	${ERL} -pa / -s run oop1

oop2: beams
	${ERL} -pa / -s run oop2

alda: beams
	${ERL} -pa / -s run alda

prog21: beams
	${ERL} -pa / -s run prog21

prog22: beams
	${ERL} -pa / -s run prog22

clean: 
	rm -rf *.beam *.html *.dump


beams: ${MODS:%.erl=%.beam}

