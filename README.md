# svnloc

Helps get the current directory svn branch when building prompt for you terminal.

## Building

Prerequisites

1. Java 17+ GraalVM 21+
2. native-image
3. GNU Make

To build, run:

```bash
make svnloc
```

## Installing

To install, run:

```bash
make install
```

This will create a link of ``build/svnloc`` in ``$HOME/.local/bin`` directory. 

To uninstall, run:

```bash
make uninstall
```
