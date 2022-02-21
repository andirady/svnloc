INSTALL_DIR = $(HOME)/.local/bin

build/SvnLoc.class: SvnLoc.java
	javac -d build SvnLoc.java

build/svnloc: build/SvnLoc.class
	native-image -cp build SvnLoc build/svnloc

.PHONY: install
install: build/svnloc
	mkdir -p $(INSTALL_DIR) && ln -is $(PWD)/build/svnloc $(INSTALL_DIR)

.PHONY: uninstall
uninstall:
	unlink $(INSTALL_DIR)/svnloc

.PHONY: clean
clean:
	rm -rf build
