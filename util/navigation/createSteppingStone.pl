#! /usr/bin/env perl

use strict;
use warnings;

use FindBin '$Bin';
use lib "$Bin";

use Luminis::Academy qw(findGreatestSteppingStone);

print findGreatestSteppingStone(),"\n";