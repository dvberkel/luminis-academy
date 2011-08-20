#! /usr/bin/env perl

use strict;
use warnings;

use FindBin qw($Bin);
use lib "$Bin";

use Luminis::Academy qw(lastCommitAsSteppingStone);

lastCommitAsSteppingStone()
